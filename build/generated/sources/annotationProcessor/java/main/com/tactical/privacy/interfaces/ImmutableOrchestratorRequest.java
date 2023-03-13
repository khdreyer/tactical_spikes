package com.tactical.privacy.interfaces;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import com.tactical.privacy.models.StepType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link OrchestratorRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableOrchestratorRequest.builder()}.
 */
@Generated(from = "OrchestratorRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableOrchestratorRequest implements OrchestratorRequest {
  private final int companyId;
  private final String phone;
  private final String email;
  private final StepType[] stepsToProcess;

  private ImmutableOrchestratorRequest(ImmutableOrchestratorRequest.Builder builder) {
    this.companyId = builder.companyId;
    this.phone = builder.phone;
    this.email = builder.email;
    this.stepsToProcess = builder.stepsToProcess != null
        ? builder.stepsToProcess
        : OrchestratorRequest.super.getStepsToProcess().clone();
  }

  private ImmutableOrchestratorRequest(
      int companyId,
      String phone,
      String email,
      StepType[] stepsToProcess) {
    this.companyId = companyId;
    this.phone = phone;
    this.email = email;
    this.stepsToProcess = stepsToProcess;
  }

  /**
   * @return The value of the {@code companyId} attribute
   */
  @Override
  public int getCompanyId() {
    return companyId;
  }

  /**
   * @return The value of the {@code phone} attribute
   */
  @Override
  public String getPhone() {
    return phone;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * @return A cloned {@code stepsToProcess} array
   */
  @Override
  public StepType[] getStepsToProcess() {
    return stepsToProcess.clone();
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OrchestratorRequest#getCompanyId() companyId} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for companyId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOrchestratorRequest withCompanyId(int value) {
    if (this.companyId == value) return this;
    return new ImmutableOrchestratorRequest(value, this.phone, this.email, this.stepsToProcess);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OrchestratorRequest#getPhone() phone} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for phone
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOrchestratorRequest withPhone(String value) {
    String newValue = Objects.requireNonNull(value, "phone");
    if (this.phone.equals(newValue)) return this;
    return new ImmutableOrchestratorRequest(this.companyId, newValue, this.email, this.stepsToProcess);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OrchestratorRequest#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOrchestratorRequest withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableOrchestratorRequest(this.companyId, this.phone, newValue, this.stepsToProcess);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OrchestratorRequest#getStepsToProcess() stepsToProcess}.
   * The array is cloned before being saved as attribute values.
   * @param elements The non-null elements for stepsToProcess
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOrchestratorRequest withStepsToProcess(StepType... elements) {
    StepType[] newValue = elements.clone();
    return new ImmutableOrchestratorRequest(this.companyId, this.phone, this.email, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableOrchestratorRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableOrchestratorRequest
        && equalTo(0, (ImmutableOrchestratorRequest) another);
  }

  private boolean equalTo(int synthetic, ImmutableOrchestratorRequest another) {
    return companyId == another.companyId
        && phone.equals(another.phone)
        && email.equals(another.email)
        && Arrays.equals(stepsToProcess, another.stepsToProcess);
  }

  /**
   * Computes a hash code from attributes: {@code companyId}, {@code phone}, {@code email}, {@code stepsToProcess}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + companyId;
    h += (h << 5) + phone.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + Arrays.hashCode(stepsToProcess);
    return h;
  }

  /**
   * Prints the immutable value {@code OrchestratorRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("OrchestratorRequest")
        .omitNullValues()
        .add("companyId", companyId)
        .add("phone", phone)
        .add("email", email)
        .add("stepsToProcess", Arrays.toString(stepsToProcess))
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link OrchestratorRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable OrchestratorRequest instance
   */
  public static ImmutableOrchestratorRequest copyOf(OrchestratorRequest instance) {
    if (instance instanceof ImmutableOrchestratorRequest) {
      return (ImmutableOrchestratorRequest) instance;
    }
    return ImmutableOrchestratorRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableOrchestratorRequest ImmutableOrchestratorRequest}.
   * <pre>
   * ImmutableOrchestratorRequest.builder()
   *    .companyId(int) // required {@link OrchestratorRequest#getCompanyId() companyId}
   *    .phone(String) // required {@link OrchestratorRequest#getPhone() phone}
   *    .email(String) // required {@link OrchestratorRequest#getEmail() email}
   *    .stepsToProcess(com.tactical.privacy.models.StepType) // optional {@link OrchestratorRequest#getStepsToProcess() stepsToProcess}
   *    .build();
   * </pre>
   * @return A new ImmutableOrchestratorRequest builder
   */
  public static ImmutableOrchestratorRequest.Builder builder() {
    return new ImmutableOrchestratorRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableOrchestratorRequest ImmutableOrchestratorRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "OrchestratorRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements OrchestratorRequest.Builder {
    private static final long INIT_BIT_COMPANY_ID = 0x1L;
    private static final long INIT_BIT_PHONE = 0x2L;
    private static final long INIT_BIT_EMAIL = 0x4L;
    private long initBits = 0x7L;

    private int companyId;
    private @Nullable String phone;
    private @Nullable String email;
    private @Nullable StepType[] stepsToProcess;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code OrchestratorRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(OrchestratorRequest instance) {
      Objects.requireNonNull(instance, "instance");
      companyId(instance.getCompanyId());
      phone(instance.getPhone());
      email(instance.getEmail());
      stepsToProcess(instance.getStepsToProcess());
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorRequest#getCompanyId() companyId} attribute.
     * @param companyId The value for companyId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder companyId(int companyId) {
      this.companyId = companyId;
      initBits &= ~INIT_BIT_COMPANY_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorRequest#getPhone() phone} attribute.
     * @param phone The value for phone 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder phone(String phone) {
      this.phone = Objects.requireNonNull(phone, "phone");
      initBits &= ~INIT_BIT_PHONE;
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorRequest#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link OrchestratorRequest#getStepsToProcess() stepsToProcess} attribute.
     * <p><em>If not set, this attribute will have a default value as defined by {@link OrchestratorRequest#getStepsToProcess() stepsToProcess}.</em>
     * @param stepsToProcess The elements for stepsToProcess
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder stepsToProcess(StepType... stepsToProcess) {
      this.stepsToProcess = stepsToProcess.clone();
      return this;
    }

    /**
     * Builds a new {@link ImmutableOrchestratorRequest ImmutableOrchestratorRequest}.
     * @return An immutable instance of OrchestratorRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableOrchestratorRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableOrchestratorRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_COMPANY_ID) != 0) attributes.add("companyId");
      if ((initBits & INIT_BIT_PHONE) != 0) attributes.add("phone");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      return "Cannot build OrchestratorRequest, some of required attributes are not set " + attributes;
    }
  }
}
